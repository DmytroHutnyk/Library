package hutnyk.library.Service;

import hutnyk.library.Service.Interface.IPublisherService;
import hutnyk.library.model.Publisher;
import hutnyk.library.repository.IPublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PublisherService implements IPublisherService {
    private final IPublisherRepository publisherRepository;

    public Optional<Publisher> findByName(String name){
        return publisherRepository.findByPublisherName(name);
    }

    public Publisher save(Publisher publisher){
        return publisherRepository.save(publisher);
    }
}
