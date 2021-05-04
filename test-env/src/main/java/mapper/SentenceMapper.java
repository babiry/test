package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.Sentence;

@Mapper
public interface SentenceMapper {

      Sentence select(String id);

      List<Sentence> selectAll();

      void insert(Sentence sentence);
      
      boolean update(Sentence sentence);
}
