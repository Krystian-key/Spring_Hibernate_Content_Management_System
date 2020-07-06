package pl.springhibernate.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springhibernate.springcms.dao.ArticleDao;
import pl.springhibernate.springcms.entity.Article;
import java.util.List;


@Controller
public class HomeController {

    private ArticleDao articleDao;

    public HomeController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("")
    @ResponseBody
    public List<Article> home() {
        List<Article> articles = articleDao.getLastFive();
        return articles;
    }
}