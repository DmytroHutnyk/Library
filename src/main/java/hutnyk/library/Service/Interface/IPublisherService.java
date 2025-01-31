package hutnyk.library.Service.Interface;

import hutnyk.library.model.Publisher;

import java.util.Optional;

public interface IPublisherService {
    Optional<Publisher> findByName(String name);
    Publisher save(Publisher publisher);
}
