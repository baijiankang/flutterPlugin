import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:toast_provider/toast_provider.dart';

void main() {
  const MethodChannel channel = MethodChannel('toast_provider');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await ToastProvider.platformVersion, '42');
  });
}
