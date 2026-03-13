# AI Agent Rules

- Always follow feature module architecture under `backend/src/main/java/com/example/app/modules`.
- Never call repository from controller.
- Always go through service layer.
- DTO classes must stay inside `dto/request` and `dto/response` packages.
- New modules must be generated using `scripts/generate-module.sh`.
- All code must pass `mvn verify`.
- If rules fail, fix code instead of disabling rules.
