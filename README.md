# rx-dialog

[![CircleCI](https://circleci.com/gh/yongjhih/rx-dialog.svg?style=shield)](https://circleci.com/gh/yongjhih/rx-dialog)
[![codecov](https://codecov.io/gh/yongjhih/rx-dialog/branch/master/graph/badge.svg)](https://codecov.io/gh/yongjhih/rx-dialog)

## Usage

```kt
checkButton.checkedChanges()
  .flatMapMaybe {
    RxDialog.confirm(AlertDialog.Builder(activity)
      .setTitle("Are you sure?"),
      if (it) "Enable" else "Disable",
      "Cancel")
  }
  .subscribe()
```

## Installation

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.rx-dialog:rx-dialog:-SNAPSHOT'
    //compile 'com.github.yongjhih.rx-dialog:rx-dialog-kotlin:-SNAPSHOT' // optional
}
```

## License

Apache 2.0

ref. https://gist.github.com/yongjhih/138a166473c7635367faba5821e61bc2
