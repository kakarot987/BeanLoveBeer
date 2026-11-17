# Legacy dependency update and security status

This branch combines the version and transitive-lockfile changes from historical Dependabot PRs **#4–#9** on top of current `master`. The diffs were consolidated at the package-lock dependency entry level, not by blindly replacing the whole lockfile from one bot PR.

- Karma is updated within its existing 5.0.x major.
- The lockfile incorporates the bot-generated changes for `socket.io-parser`, `jszip`, `qs`, `json5`, `decode-uri-component` and `minimist`, including changes to associated transitive packages.
- A clean npm 6 installation and Angular 9 production build are required on GitHub Actions.
- This update is **not** a security modernization. Angular 9, TypeScript 3.8, old build tooling and Node 14 remain obsolete. Do not deploy this frontend publicly without a full supported-toolchain migration and a security review.

The project is retained for historical portfolio use. You may archive the repository through GitHub settings once reviewed, but archiving by itself does not patch vulnerabilities. Do not claim that every vulnerability is resolved because these selected updates merged.
