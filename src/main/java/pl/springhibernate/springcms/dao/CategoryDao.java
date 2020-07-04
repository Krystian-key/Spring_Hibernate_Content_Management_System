package pl.springhibernate.springcms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springhibernate.springcms.entity.Article;
import pl.springhibernate.springcms.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoryDao {

    // zapisywanie
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    //pobieranie

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    //updatowanie

    public void update(Category category) {
        entityManager.merge(category);
    }

    //deletowanie

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
}
