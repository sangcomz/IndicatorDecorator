# IndicatorDecorator
Indicator decorator is an indicator that can be used in ViewPager2 and RecyclerView.

## What's New in 0.1.0? :tada:
- [Feature] Indicators to overlap. Use`isOverlap` (#2)

## How to Use

### Gradle
```groovy
    dependencies {
        implementation 'xyz.sangcomz:indicatordecorator:0.1.0'
    }
```
### Usage
```java
        viewPager1.addItemDecoration(IndicatorItemDecoration().apply {
            indicatorShape = CircleIndicator().apply {
                colorActive = ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark)
            }
        })
```

#### attribute

|      Attribute Name        | Description                               |    Default Value    |
|:--------------------------:|-------------------------------------------|:-------------------:|
|          topOffset         | Top Offset with Page Item                 |         4DP         |
|         bottomOffset       | Bottom Offset in View                     |         4DP         |
|     indicatorItemPadding   | Padding between indicators                |         8DP         |
|        indicatorShape      | Indicator shape                           |    CircleIndicator  |
|          isOverlap         | Can overlap                               |        false        |

#### Support Indicator Shape

- CircleIndicator
- DrawableIndicator
- SquareIndicator

It can be created by extend IndicatorShape. (It's better if you make a PR)

## Result Screen

| Project Name | Result Screen   |
|:---------:|---|
| Sample  |  <img src="/pic/sample.gif"> |

# Contribute
Welcome any contributions.

# Inspired by
 * [bleeding182/recyclerviewItemDecorations](https://github.com/bleeding182/recyclerviewItemDecorations), I was inspired by his code.

# License

    Copyright 2019 Jeong Seokwon

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
