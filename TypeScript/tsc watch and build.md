### Step 1: Initialize a TypeScript Project

If you haven't already, you need to first initialize a TypeScript project by creating a `tsconfig.json` file in the root of your project directory. This file contains the configuration for the TypeScript compiler.

You can create a `tsconfig.json` file manually or use the `tsc` command:

```bash
tsc --init
```

Run the following command in your project directory:

```bash
tsc
```

This command will read the `tsconfig.json` file and compile all the TypeScript files specified in the `include` option

### Step 5: Watch Mode (Optional)

During development, it's useful to have the compiler automatically recompile your TypeScript files whenever you make changes. You can achieve this by using the `--watch` or `-w` option with the `tsc` command:

```bash
tsc -w
```

Copied

This will keep the TypeScript compiler running in the background, and it will automatically recompile your files whenever you save changes.