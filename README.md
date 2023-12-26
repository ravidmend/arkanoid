# Arkanoid Game

## Introduction

This is an extended version of the classic Arkanoid game, implementing new features and improvements. The game includes a pause screen, a countdown screen before each level, support for multiple levels, and an end screen. Follow the sections below to understand the changes and features added.

## Part 1: Reorganization and Pause Feature

### Animation Loop Code

The game's main loop has been reorganized for better modularity. The `Animation` interface and `AnimationRunner` class have been introduced to separate game-specific logic from GUI and frame-rate management.

### Pause Screen

Pressing the 'p' key during gameplay triggers a pause screen with the message "paused -- press space to continue." This allows players to take a break and resume the game at their convenience.

### Bonus Feature: 3... 2... 1... (GO)

At the beginning of each level, a countdown from 3 to 1 is displayed, creating a brief anticipation before gameplay begins.

## Part 2: Multiple Levels

### LevelInformation Interface

A new interface called `LevelInformation` has been introduced to specify the information required for each game level. This includes details such as the number of balls, initial ball velocities, paddle speed, paddle width, level name, background, blocks, and the number of blocks to remove.

### Create Three Levels

Three classes have been implemented, each corresponding to a different level layout. These levels differ in background color, ball properties, paddle characteristics, block layout, and a unique level name.

### Initialize GameLevel Based on LevelInformation

The `GameLevel` constructor now accepts a `LevelInformation` object, allowing the initialization of game elements based on the specified level information.

### GameFlow Class

A new class named `GameFlow` has been introduced to manage the flow of the game through different levels. It iterates through a list of `LevelInformation` objects, creating and running the corresponding `GameLevel`.

## Part 3: End Screen

### End Screen

After completing all levels or losing the game, an end screen is displayed. The screen shows the final score along with a message: "Game Over. Your score is X" or "You Win! Your score is X." Pressing the space key terminates the game.

## Part 4: Further Re-organization

### KeyPressStoppableAnimation

A new class called `KeyPressStoppableAnimation` has been introduced to handle the common behavior of waiting for a key press in animations. This class decorates existing animations, adding a "waiting-for-key" behavior.

### Bug Fix

A bug related to immediate exit when pressing the same key for consecutive animations has been addressed. The fix ensures that the key press is only recognized if it occurred after the animation started.

## Final Integration

### Ass6Game

A new class named `Ass6Game` serves as the entry point for the game. It supports running the game with three levels in sequence or running specific levels based on command-line arguments.

### Example Run

To run the example, use the command: `java -jar ass6example.jar`. Ensure that the game behaves as expected, supporting features such as pausing, resuming, and displaying countdowns.

## Bonus Points

Up to 10 bonus points can be earned by hiting the last block at each lever


Enjoy playing the extended Arkanoid game!
