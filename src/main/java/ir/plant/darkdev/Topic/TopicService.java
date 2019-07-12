package ir.plant.darkdev.Topic;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    private List<TopicModel> topicModels = new ArrayList<>(Arrays.asList(
            new TopicModel("django", "DjangoName goes here", "Django des goes here")
            , new TopicModel("spring", "SpringName goes here", "Spring des goes here")
            , new TopicModel("laravel", "LaravelName goes here", "Laravel des goes here")
    ));

    public List<TopicModel> getAll() {
        return topicModels;
    }

    public TopicModel getOne(String id) {
        return topicModels.stream()
                .filter(tm -> tm.getId().equals(id))
                .findFirst()
                .get();
    }

    public void addOne(TopicModel newTopic) {
        topicModels.add(newTopic);
    }

    public void removeOne(String id) {
        topicModels.remove(topicModels.stream()
                .filter(tm -> tm.getId().equals(id))
                .findFirst()
                .get());
    }

    public void updateTopic(String id, TopicModel newTopic) {
        boolean result = topicModels.removeIf(tm -> tm.getId().equals(id));
        if (result) {
            topicModels.add(new TopicModel(newTopic.getId()
                    , newTopic.getName(), newTopic.getDescription()));
        }
    }
}
