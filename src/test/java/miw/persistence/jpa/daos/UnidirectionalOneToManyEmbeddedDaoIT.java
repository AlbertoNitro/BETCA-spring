package miw.persistence.jpa.daos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import miw.persistence.jpa.daos.UnidirectionalOneToManyEmbeddedDao;
import miw.persistence.jpa.entities.AnyClass;
import miw.persistence.jpa.entities.UnidirectionalOneToManyEmbeddedEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnidirectionalOneToManyEmbeddedDaoIT {

    @Autowired
    private UnidirectionalOneToManyEmbeddedDao unidirectionalOneToManyEmbeddedDao;

    private AnyClass[] array = {new AnyClass(0, "cero"), new AnyClass(1, "uno"), new AnyClass(2, "dos"), new AnyClass(3, "tres")};

    private UnidirectionalOneToManyEmbeddedEntity entity;

    @Before
    public void before() {
        this.entity = new UnidirectionalOneToManyEmbeddedEntity("Mi Nick", array);
    }

    @Test
    public void testFindOne() {
        unidirectionalOneToManyEmbeddedDao.save(entity);
        UnidirectionalOneToManyEmbeddedEntity unidirectionalOneToManyEmbeddedEntity = unidirectionalOneToManyEmbeddedDao
                .findOne(this.entity.getId());
        assertEquals("Mi Nick", unidirectionalOneToManyEmbeddedEntity.getNick());
        assertEquals(4, unidirectionalOneToManyEmbeddedEntity.getAnyClassArray().length);
    }

    @After
    public void delete() {
        unidirectionalOneToManyEmbeddedDao.delete(entity.getId());
    }

}
