# BeanLoveBeer (2020) — historical Spring Boot + Angular app

An early beer catalog/favorites example built with Java 8, Spring Boot 2.2.6, Angular and MySQL. It demonstrates a searchable browser UI, favorites, media uploads and REST persistence. It is retained as a historical learning project rather than a current production portfolio flagship.

## Safety and maintenance

- **Do not expose this service to the public internet.** Its write and upload endpoints do not implement authentication or authorization.
- Set database connection credentials via `SPRING_DATASOURCE_URL`, `DB_USERNAME` and `DB_PASSWORD`. Do not reuse credentials previously committed in Git history.
- Upload limits are reduced to 2 MB, but uploaded file content/type still requires full validation before any public deployment.
- The frontend favorite request now sends a JSON object and save endpoints return persisted entities.
- Generated files and raw MySQL `.ibd` storage pages are still present in Git history and may remain tracked in the current tree. The new `.gitignore` prevents newly untracked files from being added, **not** removal of existing tracked content.

The historical toolchain, build, local database and browser flows have not been newly validated. Consider archiving the repository once review is complete; archiving is a repository-settings decision, not something this PR performs.
