package com.example.mongodb_crud_demo3_ii.service;


import com.example.mongodb_crud_demo3_ii.model.Author;
import com.example.mongodb_crud_demo3_ii.model.Book;
import com.example.mongodb_crud_demo3_ii.model.Category;
import com.example.mongodb_crud_demo3_ii.model.create_request.AuthorCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.create_request.BookCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.create_request.CategoryCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.AuthorUpdateRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.BookUpdateRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.CategoryUpdateRequest;
import com.example.mongodb_crud_demo3_ii.repository.AuthorRepository;
import com.example.mongodb_crud_demo3_ii.repository.BookRepository;
import com.example.mongodb_crud_demo3_ii.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public Author createAuthor(AuthorCreationRequest request) {
        Author author = new Author();
        BeanUtils.copyProperties(request, author);
        return authorRepository.save(author);
    }

    public Category createCategory(CategoryCreationRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        return categoryRepository.save(category);
    }

    public Book createBook(BookCreationRequest request) {
        Optional<Author> author = authorRepository.findById(request.getAuthorId());
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());

        if (author.isEmpty() || category.isEmpty())
            return null;

        Book book = new Book();
        BeanUtils.copyProperties(request, book);
        book.setAuthor(author.get());
        book.setCategory(category.get());
        return bookRepository.save(book);
    }

    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Book> findAllBook () {
        return bookRepository.findAll();
    }

    public Author updateAuthor (AuthorUpdateRequest request) {
        Optional<Author> authorOptional = authorRepository.findById(request.getId());

        if (authorOptional.isEmpty())
            return null;

        Author author = authorOptional.get();

        BeanUtils.copyProperties(request, author);
        return authorRepository.save(author);
    }

    public Category updateCategory (CategoryUpdateRequest request) {
        Optional<Category> categoryOptional = categoryRepository.findById(request.getId());

        if (categoryOptional.isEmpty())
            return null;

        Category category = categoryOptional.get();

        BeanUtils.copyProperties(request, category);
        return categoryRepository.save(category);
    }

    public Book updateBook (BookUpdateRequest request) {
        Optional<Author> authorOptional = authorRepository.findById(request.getAuthorId());
        Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());
        Optional<Book> bookOptional = bookRepository.findById(request.getId());

        if (authorOptional.isEmpty() || categoryOptional.isEmpty() || bookOptional.isEmpty())
            return null;

        Book book = bookOptional.get();
        BeanUtils.copyProperties(request, book);
        book.setAuthor(authorOptional.get());
        book.setCategory(categoryOptional.get());
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        if (bookRepository.findById(id).isEmpty())
            return;

        bookRepository.deleteById(id);
    }

    public void deleteCategory(String id) {
        if (bookRepository.findById(id).isEmpty())
            return;

        bookRepository.deleteAll(bookRepository.findAllByCategoryId(id));
        categoryRepository.delete(categoryRepository.findById(id).get());
    }

    public void deleteAuthor(String id) {
        if (authorRepository.findById(id).isEmpty())
            return;

        bookRepository.deleteAll(bookRepository.findAllByAuthorId(id));
        authorRepository.delete(authorRepository.findById(id).get());
    }
}
