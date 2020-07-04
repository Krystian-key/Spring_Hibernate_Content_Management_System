package pl.springhibernate.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springhibernate.springcms.dao.ArticleDao;
import pl.springhibernate.springcms.dao.AuthorDao;
import pl.springhibernate.springcms.entity.Article;
import pl.springhibernate.springcms.entity.Author;

@Controller
public class ArticleController {
    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

   //to Do
}
