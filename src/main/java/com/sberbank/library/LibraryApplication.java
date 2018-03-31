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
		    if (bookRepository.findAll().size() == 0) {
                Author akunin = new Author("Борис", "Акунин");
                authorRepository.save(akunin);
                Publishing zaharov = new Publishing("Захаров");
                publishingRepository.save(zaharov);
                bookRepository.save(new Book("Азазель", akunin, zaharov, 2018, 210, 5, 3, "5 комната 3 полка"));

                Author bykov = new Author("Василий", "Владимирович", "Быков");
                authorRepository.save(bykov);
                Publishing publishing = new Publishing("Молодая гвардия");
                publishingRepository.save(publishing);
                bookRepository.save(new Book("Василь Быков. Собрание сочинений в 4 томах (комплект из 4 книг)", bykov, publishing, 1985, 1656, 2, 2, "1 комната 2 полка справа"));

                Author remark = new Author("Эрих", "Мария", "Ремарк");
                authorRepository.save(remark);
                Publishing act = new Publishing("АСТ");
                publishingRepository.save(act);
                bookRepository.save(new Book("Три товарища", remark, act, 2017, 480, 2, 1, "1 полка 1 ряд"));

                Author bulgakov = new Author("Михаил", "Афанасьевич", "Булгаков");
                authorRepository.save(bulgakov);
                Publishing alphabet = new Publishing("Азбука");
                publishingRepository.save(alphabet);
                bookRepository.save(new Book("Мастер и Маргарита", bulgakov, alphabet, 2016, 480, 1, 1, "2 полка 3 ряд"));

                Author dovlatov = new Author("Сергей", "Донатович", "Довлатов");
                authorRepository.save(dovlatov);
                bookRepository.save(new Book("Наши", dovlatov, alphabet, 2013, 160, 3, 2, "2 команата 3 полка 5 ряд"));

                bookRepository.save(new Book("Компромисс", dovlatov, alphabet, 2011, 224, 3, 1, "2 команата 3 полка 6 ряд"));

                bookRepository.save(new Book("Иностранка", dovlatov, alphabet, 2011, 160, 1, 0, "2 команата 3 полка 3 ряд"));

                Author orwell = new Author("Джордж", "Оруэлл");
                authorRepository.save(orwell);
                bookRepository.save(new Book("1984", orwell, act, 2013, 320, 1, 1, "1 полка 12 ряд"));

                Author li = new Author("Харпер", "Ли");
                authorRepository.save(li);
                bookRepository.save(new Book("Убить пересмешника", li, act, 2017, 416, 1, 1, "1 полка 1 ряд"));

                Author bradbury = new Author("Рэй", "Дуглас", "Брэдбери");
                authorRepository.save(bradbury);
                Publishing eksmo = new Publishing("Эксмо");
                publishingRepository.save(eksmo);
                bookRepository.save(new Book("451° по Фаренгейту", bradbury, eksmo, 2017, 240, 1, 1, "6 комната 3 полка"));

                bookRepository.save(new Book("Жизнь взаймы", remark, act, 2017, 288, 5, 1, "1 полка 12 ряд"));

                Author golding = new Author("Уильям", "Джеральд", "Голдинг");
                authorRepository.save(golding);
                bookRepository.save(new Book("Повелитель мух", golding, act, 2017, 320, 7, 4, "2 команата 3 полка 6 ряд"));




            }
		};
	}
}

