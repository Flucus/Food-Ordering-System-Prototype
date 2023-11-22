# Food-Ordering-System-Prototype

## Overview
This repository contains a Java-based simulation of a restaurant food ordering system. It's designed to handle the process from the point when a customer places an order over the phone, to the point where the order is ready to be delivered, with an emphasis on order prioritization and membership management.

## Features

- **Ordering Process**: Simulates order placement via phone, with operators entering details into the system.
- **Priority Indicators**: Assigns priority levels to orders to manage delivery sequencing.
- **Membership Management**: Offers distinct priority levels for VIP members, registered members, and guests, with unique member ID ranges for each category.
- **Administrative Functions**: Allows staff to manage the orders, including printing order lists and deleting orders.
- **Input Validation**: Ensures robust input checking with a custom `InvalidInputException` class.

## Member ID Ranges

- **VIP Members**: 8001 - 8199
- **Registered Members**: 8200 - 8999
- **Guests**: 9000 onwards

## License

Distributed under the Apache-2.0 license. See `LICENSE` for more information.
