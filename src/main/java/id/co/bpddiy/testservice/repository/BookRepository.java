package id.co.bpddiy.testservice.repository;

import id.co.bpddiy.testservice.domain.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
