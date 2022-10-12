package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.domain.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Publisher adding:");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publications");
        publisher.setCity("ST Peternbug");
        publisher.setZip("445650");
        publisher.setState("UK");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count:"+publisherRepository.count());

        Author eric = new Author("Games","Gosling");
        Book ddd = new Book("Java","1212345");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

       Author rod = new Author("Rod","Johnson");
       Book noEJB = new Book("J2EE Development without EJB","332523");
       rod.getBooks().add(noEJB);
       noEJB.getAuthors().add(rod);

       authorRepository.save(rod);
       bookRepository.save(noEJB);

        System.out.println("Started in bootstrap");
        System.out.println("Numbers of book: "+ bookRepository.count());

    }
}
