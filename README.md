#NewsflashView
利用ViewFlipper实现类似京东快报和淘宝头条的跑马灯效果



![预览](preview.gif)


# Import
**Step 1. Add the JitPack repository to your build file**

```
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

**Step 2. Add the dependency**

```
    dependencies {
	        compile 'com.github.LLhon:NewsflashView:v1.0.2'
	}
```

# Usage


```
<com.hon.newsflashview.NewsflashView
            android:id="@+id/newsflash"
            android:layout_width="220dp"
            android:layout_height="wrap_content"
            />
```

 
```
NewsflashView newsflashView = (NewsflashView) findViewById(R.id.newsflash);
newsflashView.setNewsflash(mDatas); 
newsflashView.setOnNewsflashClickListener(new NewsflashView.OnNewsflashClickListener() {
         @Override public void onNewsflashClick(int position) {
              Toast.makeText(MainActivity.this, mDatas.get(position), Toast.LENGTH_SHORT).show();
              }
         });
newsflashView.startFlipping();
```

License
--------
The repo is released under following licenses

Copyright 2017 LLhon


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.



