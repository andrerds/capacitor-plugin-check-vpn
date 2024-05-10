 export interface CheckVpnPlugin {
  getVpnStatus(): Promise<{ vpnStatus: string | undefined }>;
  echo(options: { value: string | undefined }): Promise<{ value: string  | undefined}>;
}