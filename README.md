# android-paparazzi-sample

## paparazzi 参考リンク
- 公式
  - https://github.com/cashapp/paparazzi
- 実装の参考にした記事
  - https://hameteman.com/an-introduction-to-paparazzi-for-snapshot-testing

## paparazziを試しに実装したPR
- https://github.com/ikemura23/android-paparazzi-sample/pull/1

## テストコマンドの説明

[この記事](https://hameteman.com/an-introduction-to-paparazzi-for-snapshot-testing)によると、ゴールデン値？を作るため、まず比較元の画像（これがたぶんゴールデン値）を作るgradleタスクを実行する

```
./gradlew :app:recordPaparazziDebug

> Task :app:testDebugUnitTest
See the Paparazzi report at: file:///Users/k_ikemura/dev/android-paparazzi-sample/app/build/reports/paparazzi/index.html

BUILD SUCCESSFUL in 8s
24 actionable tasks: 1 executed, 23 up-to-date

```

これがSuccessした後に、比較するテストを行うコマンドを実行する

```
./gradlew :app:verifyPaparazziDebug                                                                                                                                    ✘ 130 

> Task :app:testDebugUnitTest
See the Paparazzi report at: file:///Users/k_ikemura/dev/android-paparazzi-sample/app/build/reports/paparazzi/index.html

BUILD SUCCESSFUL in 8s
24 actionable tasks: 1 executed, 23 up-to-date
```

## 比較元の値を作っていない場合は？

gradleタスクが失敗する

```
./gradlew :app:verifyPaparazziDebug

> Task :app:testDebugUnitTest

com.ikemura23.paparazzi.sample.TagTest > testTag FAILED
    java.lang.AssertionError at TagTest.kt:20

2 tests completed, 1 failed

> Task :app:testDebugUnitTest FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:testDebugUnitTest'.
> There were failing tests. See the report at: file:///Users/k_ikemura/dev/android-paparazzi-sample/app/build/reports/tests/testDebugUnitTest/index.html

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 7s
24 actionable tasks: 1 executed, 23 up-to-date
```

ログのindex.htmlにはこんなログが出ていた

```
java.lang.AssertionError: File src/test/snapshots/images/com.ikemura23.paparazzi.sample_TagTest_testTag_tag.png does not exist
	at app.cash.paparazzi.SnapshotVerifier$newFrameHandler$1.handle(SnapshotVerifier.kt:46)
	at app.cash.paparazzi.Paparazzi$takeSnapshots$1$2.invoke(Paparazzi.kt:326)
	at app.cash.paparazzi.Paparazzi$takeSnapshots$1$2.invoke(Paparazzi.kt:313)
	at app.cash.paparazzi.Paparazzi.withTime(Paparazzi.kt:361)
	at app.cash.paparazzi.Paparazzi.takeSnapshots(Paparazzi.kt:313)
...
```
