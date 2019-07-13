package ir.plant.darkdev.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public List<TopicModel> getAll() {
        List<TopicModel> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public TopicModel getOne(String id) {
        if (topicRepository.existsById(id)){
            return topicRepository.findById(id).get();
        }
        return new TopicModel();
    }

    public void addOne(TopicModel newTopic) {
        topicRepository.save(newTopic);
    }

    public void removeOne(String id) {
        topicRepository.deleteById(id);
    }

    public void updateTopic(String id, TopicModel newTopic) {
        boolean result = topicRepository.existsById(id);
        if (result){
            topicRepository.deleteById(id);
            topicRepository.save(newTopic);
        }
    }
}
