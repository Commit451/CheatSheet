# YouTubeExtractor
A helper to extract the streaming URL from a YouTube video

[![Build Status](https://travis-ci.org/Commit451/YouTubeExtractor.svg?branch=master)](https://travis-ci.org/Commit451/YouTubeExtractor)
[![](https://jitpack.io/v/Commit451/YouTubeExtractor.svg)](https://jitpack.io/#Commit451/YouTubeExtractor)

This library was originally found [here](https://github.com/flipstudio/YouTubeExtractor) in a project by [flipstudio](https://github.com/flipstudio). It has since been modified and cleaned up a bit to make it more user friendly.

# Usage
Under the hood, this library uses [Retrofit](http://square.github.io/retrofit/) to fetch the video metadata. If you are familiar with the Retrofit public API, this library will be a breeze for you.
This library is only responsible for getting the information needed from a YouTube video given its video id (which can be found in the url of any youtube video. It is not responsible for playback of the video. However, you can see in the sample app how this can be done using `MediaPlayer` and a `SurfaceView`
Typical usage looks like this:
```java
// You probably would want to keep one of these extractors around.
YouTubeExtractor extractor = YouTubeExtractor.create();
mExtractor.extract(GRID_YOUTUBE_ID).enqueue(new Callback<YouTubeExtractionResult>() {
    @Override
    public void onResponse(Call<YouTubeExtractionResult> call, Response<YouTubeExtractionResult> response) {
        Uri hdUri = result.getHd1080VideoUri();
                    //See the sample for more
    }

    @Override
    public void onFailure(Call<YouTubeExtractionResult> call, Throwable t) {
        t.printStackTrace();
        //Alert your user!
    }
});
```
As you can with Retrofit, you can also extract the result right away:
```java
// this will extract the result on the current thread. Don't use this on the main thread!
Response<YouTubeExtractionResult> response = extractor.extract().execute();
if (response.isSuccessful()) {
    //do your thing(s)
}
```

# Video Playback
As stated before, this library was only created to extract video stream Urls from YouTube. I recommend using the [ExoMedia](https://github.com/brianwernick/ExoMedia) library to play the video streams to the user. See the sample app for this library for an example.

License
--------

    Copyright 2016 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
