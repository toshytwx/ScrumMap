package gmail.dimon0272.WebApp.service.call;

import gmail.dimon0272.WebApp.dao.CallDao;
import gmail.dimon0272.WebApp.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 29.10.2017.
 */
@Service
public class CallServiceImpl implements CallService {
    @Autowired
    private CallDao callDao;

    @Override
    public void add(Call call) {
        callDao.add(call);
    }

    @Override
    public void delete(Call call) {
        callDao.delete(call);
    }

    @Override
    public void update(Call call) {
        callDao.update(call);
    }

    @Override
    public Call findCallById(Long id) {
        return callDao.findByCallId(id);
    }
}
