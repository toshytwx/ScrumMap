package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Call;

/**
 * Created by User on 29.10.2017.
 */
public interface CallDao {
    void add(Call call);
    void delete(Call call);
    void update(Call call);
    Call findByCallId(Long id);
}
