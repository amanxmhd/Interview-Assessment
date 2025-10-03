import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class DetailPage extends StatelessWidget {
  const DetailPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Flutter Detail Page'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          // Close Flutter and return to Native
          onPressed: () => SystemNavigator.pop(),
        ),
      ),
      body: const Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Detail Page',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            Text(
              'This page was opened via native Kotlin',
              style: TextStyle(fontSize: 16),
            ),
            SizedBox(height: 20),
          ],
        ),
      ),
    );
  }
}
