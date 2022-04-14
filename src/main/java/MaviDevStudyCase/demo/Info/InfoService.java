package MaviDevStudyCase.demo.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }


    public List<Info> getInfos(){
          return infoRepository.findAll();
    }
    public Info addInfo(Info info){
         return  infoRepository.save(info);
    }


}
