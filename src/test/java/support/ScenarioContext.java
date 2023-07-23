package support;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> scenarioContext;
    public static ScenarioContext BASE_INSTANCE = null;
    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (BASE_INSTANCE == null) {
            synchronized (BaseStep.class) {
                if (BASE_INSTANCE == null) {
                    BASE_INSTANCE = new ScenarioContext();
                }
            }
        }
        return BASE_INSTANCE;
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(String key) {
        return scenarioContext.get(key);
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}
