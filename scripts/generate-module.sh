#!/usr/bin/env bash
set -euo pipefail

if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <module-name>"
  exit 1
fi

MODULE="$1"
BASE="backend/src/main/java/com/example/app/modules/business/${MODULE}"
mkdir -p "${BASE}"/{controller,service,repository,entity,dto/request,dto/response}

echo "Generated module skeleton at ${BASE}"
