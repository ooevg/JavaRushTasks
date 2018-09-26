package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private static volatile Earth instance;

    public static Earth getInstance() {
        Earth localInstance = instance;
        if (localInstance == null) {
            synchronized (Earth.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Earth();
                }
            }
        }
        return localInstance;
    }
}

/* private static volatile Singleton instance;

        public static Singleton getInstance() {
		Singleton localInstance = instance;
		if (localInstance == null) {
			synchronized (Singleton.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new Singleton();
				}
			}
		}
		return localInstance;
	}*/