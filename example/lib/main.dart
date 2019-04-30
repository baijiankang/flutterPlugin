import 'package:flutter/material.dart';
import 'package:toast_provider/toast_provider.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {
  void _showMessage() {
    ToastProvider.showShortToast("我是按钮");
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Plugin example app'),
        ),
        body: new Center(
          child: new RaisedButton(
            onPressed: _showMessage,
            child: new Text("我是按钮"),
          ),
        ),
      ),
    );
  }
}
