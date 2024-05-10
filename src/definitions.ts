export interface CheckVpnPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
