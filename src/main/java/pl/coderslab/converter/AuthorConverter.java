package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Dao.AuthorDao;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Publisher;

public class AuthorConverter implements Converter<String , Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source){
        return authorDao.findByIdA(Long.parseLong(source));
    }
}

