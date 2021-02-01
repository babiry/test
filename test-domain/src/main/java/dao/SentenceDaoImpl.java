package dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.Sentence;
import mapper.SentenceMapper;

@Component
@MapperScan("mapper")
public class SentenceDaoImpl implements SentenceDao {

    @Autowired
    SentenceMapper sentence;
    
    @Override
    public List<Sentence> getSentences() {

        return sentence.selectAll();

    }
}
