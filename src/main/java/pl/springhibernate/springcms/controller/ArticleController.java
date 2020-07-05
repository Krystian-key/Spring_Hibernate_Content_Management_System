package pl.springhibernate.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springhibernate.springcms.dao.ArticleDao;
import pl.springhibernate.springcms.dao.AuthorDao;
import pl.springhibernate.springcms.dao.CategoryDao;
import pl.springhibernate.springcms.entity.Article;
import pl.springhibernate.springcms.entity.Author;
import pl.springhibernate.springcms.entity.Category;

@Controller
public class ArticleController {
    private AuthorDao authorDao;
    private ArticleDao articleDao;
    private CategoryDao categoryDao;

    public ArticleController(AuthorDao authorDao, ArticleDao articleDao, CategoryDao categoryDao){
        this.authorDao = authorDao;
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/article/add")
    @ResponseBody
    public String add(){

        Author author = new Author();
        author.setFirstName("Majk");
        author.setLastName("Delta");
        authorDao.save(author);
        Author author1 = new Author();
        author1.setFirstName("Piotr");
        author1.setLastName("Walentajn");
        authorDao.save(author1);

        Category category = new Category();
        category.setName("Horor");
        category.setDescription("U can pipi");
        categoryDao.save(category);
        Category category1 = new Category();
        category1.setName("Komedy");
        category1.setDescription("U can't pipi");
        categoryDao.save(category1);

        Article article = new Article();
        article.setTitle("Looks good");
        article.setAuthor(author);
        article.setContent("Magic");
        article.setCreatedOn(new Article().getCreatedOn());
        article.getCategories().add(category);
        articleDao.save(article);

        return "All was added";
    }
}
