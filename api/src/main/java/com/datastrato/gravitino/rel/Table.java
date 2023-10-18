/*
 * Copyright 2023 Datastrato.
 * This software is licensed under the Apache License version 2.
 */
package com.datastrato.gravitino.rel;

import com.datastrato.gravitino.Auditable;
import com.datastrato.gravitino.Namespace;
import com.datastrato.gravitino.rel.transforms.Transform;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * An interface representing a table in a {@link Namespace}. It defines the basic properties of a
 * table. A catalog implementation with {@link TableCatalog} should implement this interface.
 */
public interface Table extends Auditable {

  /** return the name of the table. */
  String name();

  /** Return the columns of the table. */
  Column[] columns();

  /** Returns the physical partitioning of the table. */
  default Transform[] partitioning() {
    return new Transform[0];
  }

  /**
   * Return the sort order of the table. If no sort order is specified, an empty array is returned.
   */
  default SortOrder[] sortOrder() {
    return new SortOrder[0];
  }

  /**
   * Return the bucketing of the table. If no bucketing is specified, Distribution.NONE is returned.
   */
  default Distribution distribution() {
    return Distribution.NONE;
  }

  /** Return the comment of the table. Null is returned if no comment is set. */
  @Nullable
  default String comment() {
    return null;
  }

  /** Return the properties of the table. Empty map is returned if no properties are set. */
  default Map<String, String> properties() {
    return Collections.emptyMap();
  }
}