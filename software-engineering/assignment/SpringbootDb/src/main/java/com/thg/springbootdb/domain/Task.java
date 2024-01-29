package com.thg.springbootdb.domain;

/**
 *
 * @param name
 * @param isComplete
 * @param priority
 */
public record Task(String name, boolean isComplete, int priority) {
}
