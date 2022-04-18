package MaviDevStudyCase.demo.Info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoServiceTest {


    @Autowired
    private InfoService infoService;
    @MockBean
    private InfoRepository infoRepository;

    private Info test_info1;

    private final Long id=23L;
    private final String il="Ankara";
    private final String ilce="Yenimahalle";
    private final List<Info> infos = new ArrayList<>();

    @org.junit.Before
    public void setUp() throws Exception {
        infoRepository = Mockito.mock(InfoRepository.class);

        infoService =new InfoService(infoRepository);

        test_info1 = new Info();

        test_info1.setId(id);
        test_info1.setIl(il);
        test_info1.setIlce(ilce);

        infos.add(test_info1); //add

        Mockito.when(infoRepository.findAll()).thenReturn(infos);

        infoRepository.save(test_info1);



    }
    @Test
    public void whenUsedGetInfo_ItShouldReturnValidInfoObject(){
        List<Info> infos = infoService.getInfos();

        assertNotNull(infos);
        assertEquals(1,infos.size());

    }
    @Test
    public void whenUsedAddInfo_ItShouldReturnValidInfo0bject(){

        List<Info> infos = infoService.getInfos();




        for(Info info : infos){
            assertEquals(test_info1.getIlce(),info.getIlce());

        }



    }


}