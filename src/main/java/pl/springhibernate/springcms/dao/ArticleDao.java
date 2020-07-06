package pl.springhibernate.springcms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springhibernate.springcms.entity.Article;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }


    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }



    public void update(Article article) {
        entityManager.merge(article);
    }



    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    public List<Article> getLastFive(){
        Query query = this.entityManager.createQuery("SELECT a.title, a.createdOn, a.content FROM Article a ORDER BY a.createdOn DESC").setMaxResults(5);
        return query.getResultList();
    }

    public List<Article> getAll() {
        Query query = this.entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }


}
