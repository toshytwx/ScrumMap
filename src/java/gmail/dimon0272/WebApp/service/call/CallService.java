package gmail.dimon0272.WebApp.service.call;

import gmail.dimon0272.WebApp.model.Call;

/**
 * Created by User on 29.10.2017.
 */
public interface CallService {
    void add(Call call);
    void delete(Call call);
    void update(Call call);
    Call findCallById(Long id);
}
