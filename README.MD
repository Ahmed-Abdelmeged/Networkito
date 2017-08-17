Networkito
========
Library for monitoring internet connectivity changes in android. And work with the new
**Android Architecture Components**

Download
--------

Gradle
```groovy
compile 'com.ahmedabdelmeged:networkito:1.0.0'
```
Getting started
========

 The library can use with normal android components or you can use it with Android Architecture Components. [JavaSamples](https://github.com/Ahmed-Abdelmeged/Networkito/tree/master/app/src/main/java/com/abdelmeged/ahmed/networkitotest/java), [KotlinSamples](https://github.com/Ahmed-Abdelmeged/Networkito/tree/master/app/src/main/java/com/abdelmeged/ahmed/networkitotest/kotlin)

 * Android Architecture Components

    1- Your activity must extend ```LifecycleActivity``` ,```LifecycleFragment``` or implement ```LifecycleRegistryOwner```

    2- Now initialize the ```Networkito``` at your ```onCreate()```

    You can use the callbacks by make your activity or fragment implement ```ConnectivityChangeListener```

    and Override the two methods

    ```java
    Networkito networkito = new (context, lifecycleOwner, connectivityChangeListener);

    @Override
    public void onInternetConnected(ConnectionType connectionType) {
    }

    @Override
    public void onInternetDisconnected() {
    }
    ```
    
    or use the listener
    ```java
    Networkito networkito = new (context, lifecycleOwner);

    networkito.setConnectivityChangeListener(new ConnectivityChangeListener() {
         @Override
         public void onInternetConnected(ConnectionType connectionType) {
         }

         @Override
         public void onInternetDisconnected() {
         }
     });
     ```

* Normal use

  1- initialize the ```Networkito``` at your ```onCreate()```

  You can use the callbacks by make your activity or fragment implement ```ConnectivityChangeListener```

  ```java
  Networkito networkito = new (context, connectivityChangeListener);

  @Override
  public void onInternetConnected(ConnectionType connectionType) {
  }

  @Override
  public void onInternetDisconnected() {
  }
  ```

  or use the listener
  ```java
    Networkito networkito = new (context);

    networkito.setConnectivityChangeListener(new ConnectivityChangeListener() {
             @Override
             public void onInternetConnected(ConnectionType connectionType) {
             }

             @Override
             public void onInternetDisconnected() {
             }
         });
    ```

  and at normal don't forget to **unRegisterNetworkito**
  ```java
  @Override
     protected void onStop() {
         super.onStop();
         networkito.unRegisterNetworkitoReceiver();
     }
  ```

* You can use ```isAvailableInternetConnection()``` to check the internet also

* Know the connectionType whether is **WIFI** or **Mobile**



License
========

Copyright (c) 2017 Ahmed-Abdelmeged.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
