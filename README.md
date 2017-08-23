# CheatSheet
Quick setup for Long Press tooltips on views, similar to the default ActionBar/Toolbar behavior. Originally contained within [AOSP](https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/java/com/android/internal/view/menu/ActionMenuItemView.java), this version found within [Telecine](https://github.com/JakeWharton/Telecine)

[![Build Status](https://travis-ci.org/Commit451/CheatSheet.svg?branch=master)](https://travis-ci.org/Commit451/CheatSheet)
[![](https://jitpack.io/v/Commit451/CheatSheet.svg)](https://jitpack.io/#Commit451/CheatSheet)

# Deprecated
This is now supported as of API 26, using the [Tooltip API](https://developer.android.com/guide/topics/ui/tooltips) or [TooltipCompat](https://developer.android.com/reference/android/support/v7/widget/TooltipCompat.html)

![Image](art/screenshot1.png)

# Usage
```java
CheatSheet.setup(fab, "This is how you favorite");
```
or
```java
CheatSheet.setup(fab, R.string.favorite);
```
This will establish a long click listener on the `fab` view, and any time it is long clicked, a `Toast` will appear near the view (similar to what happens when you long press an item in a typical `ActionBar/Toolbar`

If you want to customize the style of the Toasts that appear, use a factory:
```java
CheatSheet.setFactory(new CheatSheet.Factory() {
    @NonNull
    @Override
    public Toast createToast(@NonNull View view, @NonNull CharSequence text) {
        //do all the custom things you want
        return Toast.makeText(view.getContext(), text, Toast.LENGTH_LONG)
            .setView(new CustomView(view.getContext()));
    }
});
```
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
