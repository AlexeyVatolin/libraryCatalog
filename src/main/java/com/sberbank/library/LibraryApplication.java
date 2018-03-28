package com.sberbank.library;

import com.sberbank.library.entity.Author;
import com.sberbank.library.entity.Book;
import com.sberbank.library.entity.Publishing;
import com.sberbank.library.repository.AuthorRepository;
import com.sberbank.library.repository.BookRepository;
import com.sberbank.library.repository.PublishingRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

    private final AuthorRepository authorRepository;
    private final PublishingRepository publishingRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryApplication(AuthorRepository authorRepository, PublishingRepository publishingRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publishingRepository = publishingRepository;
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
    InitializingBean sendDatabase() {
		return () -> {
            authorRepository.save(new Author("Денис", "Иванович", "Фонвизин"));
            authorRepository.save(new Author("Александр", "Сергеевич", "Пушкин"));

            publishingRepository.save(new Publishing("Астрель"));
            publishingRepository.save(new Publishing("Эксмо"));
            publishingRepository.save(new Publishing("Азбука"));
            publishingRepository.save(new Publishing("Художественная литература"));

            Author akunin = new Author();
            akunin.setFirstName("Борис");
            akunin.setLastName("Акунин");
            authorRepository.save(akunin);
            Publishing zaharov = new Publishing("Захаров");
            publishingRepository.save(zaharov);
            bookRepository.save(new Book("Азазель", akunin, zaharov, 2018, 210));

            Author bykov = new Author("Василий", "Владимирович", "Быков");
            authorRepository.save(bykov);
            Publishing publishing = new Publishing("Молодая гвардия");
            publishingRepository.save(publishing);
            bookRepository.save(new Book("Василь Быков. Собрание сочинений в 4 томах (комплект из 4 книг)", bykov, publishing, 1985, 1656));
		};
	}
}

