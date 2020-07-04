package pl.springhibernate.springcms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springhibernate.springcms.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ArticleDao {

    // zapisywanie
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    //pobieranie

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    //updatowanie

    public void update(Article article) {
        entityManager.merge(article);
    }

    //deletowanie

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
