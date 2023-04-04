package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Publisher;

public class PublishConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {
        return publisherDao.findById(Long.parseLong(source));
    }
}
