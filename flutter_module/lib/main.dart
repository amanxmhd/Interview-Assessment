import 'package:flutter/material.dart';
import 'package:flutter_module/pages/detail_page.dart';
import 'package:flutter_module/pages/home_page.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Module',

      // Start with Home by default
      initialRoute: '/',

      routes: {
        '/': (context) => const HomePage(),
        '/detail': (context) => const DetailPage(),
      },

      // Fallback route
      onGenerateRoute: (_) =>
          MaterialPageRoute(builder: (_) => const HomePage()),
    );
  }
}
