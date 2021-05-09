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
    SentenceMapper sentenceMapper;
    
    @Override
    public Sentence getSentence(String id) {
        return sentenceMapper.select(id);
    }

    @Override
    public List<Sentence> getSentences() {
        return sentenceMapper.selectAll();
    }

    @Override
    public void insert(Sentence sentence) {
        sentenceMapper.insert(sentence);
    }
    
    @Override
    public boolean update(Sentence sentence) {
        return sentenceMapper.update(sentence);
    }
}
