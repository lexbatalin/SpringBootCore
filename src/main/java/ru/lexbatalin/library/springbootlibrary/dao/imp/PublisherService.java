package ru.lexbatalin.library.springbootlibrary.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lexbatalin.library.springbootlibrary.dao.PublisherDao;
import ru.lexbatalin.library.springbootlibrary.domain.Publisher;
import ru.lexbatalin.library.springbootlibrary.spring.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherService implements PublisherDao {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        return publisher.orElse(null);
    }

    @Override
    public Publisher save(Publisher obj) {
        return publisherRepository.save(obj);
    }

    @Override
    public void delete(Publisher obj) {
        publisherRepository.delete(obj);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0],
                PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
