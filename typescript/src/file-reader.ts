import * as fs from "fs";
import path from "path";

export function readInput(filename: string): Array<string> {
  return fs
    .readFileSync(path.resolve(__dirname, `../input/${filename}.txt`))
    .toString()
    .split("\r\n");
}
