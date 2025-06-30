#!/bin/bash

SOURCE_DIR="./src/main/java/com/springjpa/entity"
REPO_DIR="./src/main/java/com/springjpa/repository"

mkdir -p "$REPO_DIR"

find "$SOURCE_DIR" -type f -name "*.java" | while read -r file; do
    class_name=$(basename "$file" .java)
    repo_file="$REPO_DIR/${class_name}Repository.java"

    cat <<EOF > "$repo_file"
package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjpa.entity.${class_name};

@Repository
public interface ${class_name}Repository extends JpaRepository<${class_name}, Integer> {
}
EOF

    echo "Généré : $repo_file"
done